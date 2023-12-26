package org.geekbang.mini.spring.beans.factory.xml;

import org.dom4j.Element;
import org.geekbang.mini.spring.beans.*;
import org.geekbang.mini.spring.beans.factory.config.AutowireCapableBeanFactory;
import org.geekbang.mini.spring.beans.factory.config.BeanDefinition;
import org.geekbang.mini.spring.beans.factory.config.ConstructorArgumentValue;
import org.geekbang.mini.spring.beans.factory.config.ConstructorArgumentValues;
import org.geekbang.mini.spring.beans.SimpleBeanFactory;
import org.geekbang.mini.spring.beans.factory.support.DefaultListableBeanFactory;
import org.geekbang.mini.spring.core.Resource;

import java.util.ArrayList;
import java.util.List;

public class XmlBeanDefinitionReader {
    private final DefaultListableBeanFactory bf;

    public XmlBeanDefinitionReader(DefaultListableBeanFactory bf) {
        this.bf = bf;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);

            // get constructor
            List<Element> constructorElements = element.elements("constructor-arg");
            ConstructorArgumentValues AVS = new ConstructorArgumentValues();
            for (Element e : constructorElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                AVS.addArgumentValue(new ConstructorArgumentValue(pType, pName, pValue));
            }
            beanDefinition.setConstructorArgumentValues(AVS);

            // handle properties
            List<Element> propertyElements = element.elements("property");
            PropertyValues PVS = new PropertyValues();
            List<String> refs = new ArrayList<>();
            for (Element e : propertyElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                String pRef = e.attributeValue("ref");
                String pV = "";
                boolean isRef = false;
                if (pValue != null && !pValue.equals("")) {
                    pV = pValue;
                } else if (pRef != null && !pRef.equals("")) {
                    isRef = true;
                    pV = pRef;
                    refs.add(pRef);
                }
                PVS.addPropertyValue(new PropertyValue(pType, pName, pV, isRef));
            }
            beanDefinition.setPropertyValues(PVS);
            String[] refArray = refs.toArray(new String[0]);
            beanDefinition.setDependsOn(refArray);

            this.bf.registerBeanDefinition(beanId, beanDefinition);
        }
    }
}