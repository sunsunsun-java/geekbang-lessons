package org.geekbang.thinking.in.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Spring 注解属性覆盖示例
 */
@MyComponentScan2(packages = "org.geekbang.thinking.in.spring.annotation")
// @MyComponentScan2.scanBasePackages <- @MyComponentScan.scanBasePackages 隐性覆盖
public class AttributeOverridesDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(ComponentScanDemo.class);

        // 启动 Spring 应用上下文
        context.refresh();

        // 依赖查找 TestClass Bean
        // TestClass 标注 @MyComponent2
        // @MyComponent2 <- @MyComponent <- @Component
        TestClass testClass = context.getBean(TestClass.class);
        System.out.println(testClass);

        // 关闭 Spring 应用上下文
        context.close();

        System.out.println(new AttributeOverridesDemo().permute(new int[]{1,2,3}));
    }

    private int[] nums;
    private List<Integer> path;
    private boolean[] onPath;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        path = Arrays.asList(new Integer[nums.length]);
        onPath = new boolean[nums.length];
        dfs(0);
        return res;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!onPath[j]) {
                path.set(i, nums[j]);
                onPath[j] = true;
                dfs(i + 1);
                onPath[j] = false;
            }
        }
    }

}
