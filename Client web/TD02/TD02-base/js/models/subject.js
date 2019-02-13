"use strict";
/***
 * Observable subject
 */
class Subject
{
	/**
	 * Constructor
	 */
	constructor()
	{
		this.observers = [];
	}

	/**
	 * Add an observer
	 * @param observer: Observer to add
	 */
	addObserver(observer)
	{
        this.observers.push(observer);
	}

	/**
	 * Notify each observer
	 */
	notify()
	{
        this.observers.forEach(function (observer)
		{
            observer.notify();
		});
	}
}