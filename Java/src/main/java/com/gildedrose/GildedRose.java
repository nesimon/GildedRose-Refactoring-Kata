package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        //iterates through items
        for (int i = 0; i < items.length; i++) {
            //SULFURAS IS IMMUNE TO THE PATHETIC ATTEMPTS OF TIME, HE IS NEVER CHANGING
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros"))
            {
                //if cheese
                if (items[i].name.equals("Aged Brie"))
                {
                    if (items[i].quality < 50) {
                        items[i].quality += 1;
                    }
                }
                //if backstage passes
                else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                {
                    //increase value of tickets by 1
                    if (items[i].quality < 50) {
                        items[i].quality += 1;
                    }

                    //if only 10 days to concert, increase value by 1 more
                    if (items[i].sellIn < 11) {
                        if (items[i].quality < 50) {
                            items[i].quality += 1;
                        }
                    }
                    //if only 5 days to concert, increase value by 1 more if cost is less than 50
                    if (items[i].sellIn < 6) {
                        if (items[i].quality < 50) {
                            items[i].quality += 1;
                        }
                    }
                }
                //everything else (normal and conjured items)
                else
                {
                    if (items[i].quality > 0) {
                        items[i].quality -= 1;
                        //conjured items decrease in quality twice as fast
                        if(items[i].name.equals("Conjured"))
                        {
                            if (items[i].quality > 0)
                            {
                                items[i].quality -= 1;
                            }
                        }
                    }
                }

                //reduce days to sell by 1 to all but SULFURAS, HAND OF RAGNAROS!
                items[i].sellIn -= 1;

                //if items expired extra effects take place
                if (items[i].sellIn < 0) {
                    //
                    if (items[i].name.equals("Aged Brie"))
                    {
                        //cheese increases in value by 1 more since it is aged well
                        if (items[i].quality < 50) {
                            items[i].quality += 1;
                        }
                    }
                    else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                    {
                        //ticket value is 0 since it expired
                        items[i].quality = 0;
                    }
                    else
                    {
                        //reduce quality of items by 1 if expired
                        if (items[i].quality > 0) {
                            items[i].quality -= 1;
                            //conjured items decrease in quality twice as fast
                            if(items[i].name.equals("Conjured"))
                            {
                                if (items[i].quality > 0)
                                {
                                    items[i].quality -= 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}