package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality()
    {
        //iterates through items
        for (int i = 0; i < items.length; i++)
        {
            //SULFURAS IS IMMUNE TO THE PATHETIC ATTEMPTS OF TIME, HE IS NEVER CHANGING
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros"))
            {
                continue;
            }
            //if cheese
            else if (items[i].name.equals("Aged Brie"))
            {
                updateBrie(items[i]);
            }
            //if backstage passes
            else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                updateConcertTickets(items[i]);
            }
            //everything else (normal and conjured items)
            else
            {
                updateOtherItems(items[i]);
            }

            //reduce days to sell by 1 to all but SULFURAS, HAND OF RAGNAROS!
            items[i].sellIn -= 1;

            //if items expired extra effects take place
            if (items[i].sellIn < 0) {
                //
                if (items[i].name.equals("Aged Brie"))
                {
                    //cheese increases in value by 1 more since it is aged well
                    updateBrie(items[i]);
                }
                else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert"))
                {
                    //ticket value is 0 since it expired
                    items[i].quality = 0;
                }
                else
                {
                    //reduce quality of items by 1 if expired
                    updateOtherItems(items[i]);
                }
            }
        }
    }

    //
    public void updateBrie(Item items)
    {
        if (items.quality < 50)
        {
            items.quality += 1;
        }
    }

    public void updateConcertTickets(Item items)
    {
        //increase value of tickets by 1
        if (items.quality < 50)
        {
            items.quality += 1;
        }

        //if only 10 days to concert, increase value by 1 more
        if (items.sellIn < 11 && items.quality < 50)
        {
            items.quality += 1;
        }
        //if only 5 days to concert, increase value by 1 more if cost is less than 50
        if (items.sellIn < 6 && items.quality < 50)
        {
            items.quality += 1;
        }
    }

    public void updateOtherItems(Item items)
    {
        if (items.quality > 0)
        {
            items.quality -= 1;
            //conjured items decrease in quality twice as fast
            if(items.name.equals("Conjured") && (items.quality > 0))
            {
                items.quality -= 1;
            }
        }
    }
}