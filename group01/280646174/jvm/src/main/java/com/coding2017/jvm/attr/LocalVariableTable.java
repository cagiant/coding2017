package com.coding2017.jvm.attr;

import com.coding2017.jvm.clz.ClassFile;
import com.coding2017.jvm.constant.ConstantPool;
import com.coding2017.jvm.loader.ByteCodeIterator;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTable extends AttributeInfo {

    List<LocalVariableItem> items = new ArrayList<LocalVariableItem>();

    public LocalVariableTable(int attrNameIndex, int attrLen) {
        super(attrNameIndex, attrLen);
    }

    public static LocalVariableTable parse(ClassFile clzFile, ByteCodeIterator iter, int nameIndex, int length) {
        int tableLength = iter.nextU2ToInt();
        LocalVariableTable localVariableTable = new LocalVariableTable(nameIndex, length);
        for (int i = 0; i < tableLength; i++) {
            LocalVariableItem item = new LocalVariableItem();
            item.setStartPC(iter.nextU2ToInt());
            item.setLength(iter.nextU2ToInt());
            item.setNameIndex(iter.nextU2ToInt());
            item.setDescIndex(iter.nextU2ToInt());
            item.setIndex(iter.nextU2ToInt());
            localVariableTable.addLocalVariableItem(item);
        }
        return localVariableTable;
    }

    private void addLocalVariableItem(LocalVariableItem item) {
        this.items.add(item);
    }

    public String toString(ConstantPool pool) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Local Variable Table:\n");
        for (LocalVariableItem item : items) {
            buffer.append("startPC:" + item.getStartPC()).append(",");
            buffer.append("name:" + pool.getUTF8String(item.getNameIndex())).append(",");
            buffer.append("desc:" + pool.getUTF8String(item.getDescIndex())).append(",");
            buffer.append("slotIndex:" + item.getIndex()).append("\n");
        }
        buffer.append("\n");
        return buffer.toString();
    }

}
