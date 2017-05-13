package com.coding2017.jvm.print;

import com.coding2017.jvm.constant.*;

public class ConstantPoolPrinter {
    ConstantPool pool;

    ConstantPoolPrinter(ConstantPool pool) {
        this.pool = pool;
    }

    public void print() {

        System.out.println("Constant Pool:");

        ConstantInfo.Visitor visitor = new ConstantInfo.Visitor() {
            @Override
            public void visit(ClassInfo classInfo) {
                System.out.println("Class    #" + classInfo.getUtf8Index());
            }

            @Override
            public void visit(FieldRefInfo fieldRefInfo) {
                System.out.println(
                        "Fieldref    #" + fieldRefInfo.getClassInfoIndex() + ".#" + fieldRefInfo.getNameAndTypeIndex());
            }

            @Override
            public void visit(MethodRefInfo methodRefInfo) {
                System.out.println("Methodref    #" + methodRefInfo.getClassInfoIndex() + ".#"
                        + methodRefInfo.getNameAndTypeIndex());
            }

            @Override
            public void visit(NameAndTypeInfo nameAndTypeInfo) {
                System.out
                        .println("NameAndType    #" + nameAndTypeInfo.getIndex1() + ":#" + nameAndTypeInfo.getIndex2());
            }

            @Override
            public void visit(StringInfo stringInfo) {
                System.out.println("String    #" + stringInfo.getIndex());
            }

            @Override
            public void visit(UTF8Info utf8Info) {
                System.out.println("Utf8    " + utf8Info.getValue());
            }
        };

        for (int i = 1; i <= pool.getSize(); i++) {
            System.out.print("#" + i + ": ");
            pool.getConstantInfo(i).accept(visitor);
        }

    }
}
