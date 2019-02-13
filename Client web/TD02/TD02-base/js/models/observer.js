"use strict";
/**
 * Observer of subjects
 */
class Observer
{
	/**
	 * Constructor
	 */
	constructor()
	{

	}

	/**
	 * Notify function has to be overridden
	 */
	notify()
	{
		throw "Observer::notify - Abstract function not overridden";
	}
}