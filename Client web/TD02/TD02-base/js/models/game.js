"use strict";
/**
 * Game
 */
class Game
{
	/**
	 * Constructor
	 */
    constructor()
    {
        this.id = 0;
        this.title = 'New game';
        this.releaseYear = 1950;
    }

	/**
	 * Setters
	 */
    setTitle(value)
    {
        if (value != '')
        {
            this.title = value;
        }
    }

    setReleaseYear(value)
    {
        if (!isNaN(value) && value >= 1950 && value <= 2018)
        {
            this.releaseYear = value;
        }
    }

	/**
	 * Getters
	 */
    getId() { return this.id; }
    getTitle() { return this.title; }
    getReleaseYear() { return this.releaseYear; }

	/**
	 * Initialise data of the game from an array
	 */
    hydrate(data)
    {
        this.id = data.id || this.id;
        this.title = data.title || 'New game';
        this.releaseYear = data.releaseYear || 1950;
    }

    copy(game)
    {
        this.setTitle(game.getTitle());
        this.setReleaseYear(game.getReleaseYear());
    }

	/**
	 * Return the game as an array
	 */
    toArray()
    {
        var array = {
            id: this.id,
            title: this.title,
            releaseYear: this.releaseYear
        }

        return array;
    }
}
