package com.lukasluknar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {

    private final List<Item> items;
    private final String message;

    public Menu(String message) {
        this.items = new ArrayList<>();
        this.message = message;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item selectItem(final String id) {
        return items.stream().filter(i -> i.id.equals(id)).findFirst().orElse(Item.error);
    }

    public String getMessage() {
        return "\n[" + message + "] Enter action (" + items.stream().map(i -> i.id).collect(Collectors.joining(", ")) + "): ";
    }


    public static class Builder {

        private final Menu menu;

        public Builder(String message) {
            menu = new Menu(message);
        }

        public Builder addItem(Item item) {
            menu.addItem(item);
            return this;
        }

        public Builder addItem(String id, MenuAction action) {
            return addItem(new Item(id, action));
        }

        public Menu build() {
            return menu;
        }
    }


    static class Item {

        final String id;
        final MenuAction action;

        private static final Item error = new Item("error", () -> System.out.println("[error] Incorrect input! Try again."));

        public Item(String id, MenuAction action) {
            this.id = id;
            this.action = action;
        }

        @Override
        public String toString() {
            return id;
        }
    }
}
