/**
 * Web application
 */
class Application
{
    /**
     * Constructor
     */
    constructor()
    {
        this.controleur = new Controller();
        this.vue = new View(this.controleur);
    }
}


/**
 * Start the application after the loading of the page is complete
 */
window.onload = function ()
{
    let application = new Application();
};
