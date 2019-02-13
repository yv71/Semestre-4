"use strict";

/**
 * collection of items
 */
class Collection
{
	/**
	 * Constructor
	 */
	constructor()
	{
        //Items of the collection
		this.items = [];
	}

	/**
	 * Clear the collection
	 */
	clear()
	{
		this.items = [];
	}

	/**
	 * Return the size of the collection
	 */
	size()
	{
		return this.items.length;
    }

	/**
	 * Add an item to the collection
	 * @param item : item to add
	 */
	add(item)
	{
		this.items.push(item);
	}

	/**
	 * Remove an item from the collection
	 * @param index : Index of the item to remove
	 */
	remove(index)
	{
		if (index < 0 || index >= this.size())
			throw "Collection::remove - index out of range";

		this.items.splice(index, 1);
	}

	/**
	 * Replace an item by an other
	 * @param index: Index of the item to replace
	 * @item : Item to use to replace the exiting item
	 */
	replace(index, item)
    {
        if (index < 0 || index >= this.size())
            throw "Collection::replace - index out of range";

		this.at(index).copy(item);
	}

	/**
	 * Return an item of the collection
	 * @param index: Index of the item to return
	 */
	at(index)
	{
		if (index < 0 || index >= this.size())
			throw "Collection::at - index out of range";

		return this.items[index];
	}

	/**
	 * Call a callback handling for each item of the collection
	 * @param callback: callback to call
	 */
	forEach(callback)
	{
		for(var index = 0; index < this.size(); ++index)
        {
            try
            {
                callback(this.at(index));
            }
            catch (exception)
            {
            }
		}
	}

	/**
	 * Sort the collection
	 * @param sortFunction: callback used to sort items : function(item1, item2): number => 1 : item1 > item2, -1 : item1 < item2, 0: item1 = item2
	 */
	sort(sortFunction)
	{
		this.items.sort(sortFunction);
	}

	/**
	 * Return the collection in the form of an array
	 */
	toArray()
	{
		var array = [];

		this.forEach(function (item)
		{
			array.push(item.toArray());
		});

		return array;
	}
}