package com.coding2017.jvm.cmd;

import com.coding2017.jvm.clz.ClassFile;
import com.coding2017.jvm.constant.ConstantPool;

public class InvokeVirtualCmd extends TwoOperandCmd {

    public InvokeVirtualCmd(ClassFile clzFile, String opCode) {
        super(clzFile, opCode);
    }

    @Override
    public String toString(ConstantPool pool) {

        return super.getOperandAsMethod(pool);
    }

}
