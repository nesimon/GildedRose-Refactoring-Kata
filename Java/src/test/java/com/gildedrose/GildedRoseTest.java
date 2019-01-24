package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    public void brieTest() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 2, 0), //
                new Item("Aged Brie", 0, 4)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, 1, 1", app.items[0].toString());
        assertEquals("Aged Brie, -1, 6", app.items[1].toString());
    }

    @Test
    public void concertTest() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 42),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 44),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 47)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 14, 21", app.items[0].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 8, 44", app.items[1].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, 3, 47", app.items[2].toString());
        assertEquals("Backstage passes to a TAFKAL80ETC concert, -1, 0", app.items[3].toString());
    }

    @Test
    public void otherItemsTest() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Elixir of the Big Mongoose", 0, 7), //
                new Item("Conjured", 3, 10),
                new Item("Conjured", 0, 10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("+5 Dexterity Vest, 9, 19", app.items[0].toString());
        assertEquals("Elixir of the Mongoose, 4, 6", app.items[1].toString());
        assertEquals("Elixir of the Big Mongoose, -1, 5", app.items[2].toString());
        assertEquals("Conjured, 2, 8", app.items[3].toString());
        assertEquals("Conjured, -1, 6", app.items[4].toString());
    }

    @Test
    public void sulfurasTest() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 2, 80)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros, 2, 80", app.items[0].toString());
    }
}
