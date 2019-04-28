package part01.lesson04.task03;

import java.util.*;

public class ObjectBox<T> {
    protected Collection<T> box;

    public ObjectBox() {
        box = new ArrayList<>();
    }

    /**
     * Добавляет элемент в коллекцию
     * @param element
     */
    public void addElement(T element) {
        box.add(element);
    }

    /**
     * Удаляет элемент из коллекции, если он там есть
     * @param element
     */
    public void deleteElement(T element) {
        box.remove(element);
    }

    /**
     * Склеивает элементы в строку, состоящую из элементов, разделенных ", "
     * @return склеенная строка
     */
    public String dump() {
        StringBuilder builder = new StringBuilder();
        Iterator<T> iterator = box.iterator();
        while (iterator.hasNext()) {
            T o = iterator.next();
            builder.append(o.toString());
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    /**
     *
     * @return Количество элементов в коллекции
     */
    public int size() {
        return box.size();
    }
}
