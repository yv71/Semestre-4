"use strict";
/**
 * Collection of games
 */
class Games extends Collection
{
	/**
	 * Constructor
	 */
    constructor()
    {
        super();
    }

	/**
	 * Initialise the collection from an array
	 */
    hydrate(array)
    {
        this.clear();

        if (array)
        {
            var that = this;

            array.forEach(function (data)
            {
                var game = new Game();
                game.hydrate(data);

                that.add(game);
            });
        }
    }

	/**
	 * Sort the collection
	 */
    sort()
    {
        super.sort(function (a, b)
        {
            if (a.getTitle() < b.getTitle())
                return -1;
            else if (a.getTitle() == b.getTitle())
                return 0;
            else
                return 1;
        });
    }
}