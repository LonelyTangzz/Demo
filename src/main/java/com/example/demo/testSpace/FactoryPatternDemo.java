package com.example.demo.testSpace;

/**
 * @author tangzy.
 * @version 1.0
 * @date 2020/10/13.
 * @name: FactoryPatternDemo
 * @description: 工厂模式实例演示
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }

}
