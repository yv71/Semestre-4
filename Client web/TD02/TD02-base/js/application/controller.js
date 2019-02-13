/**
 *  Controller of the Web application
 */
class Controller extends Subject
{
    /**
     * Constructor
     */
    constructor()
    {
        super();
        this.games= new Games();
    }

    addGame(game)
    {
        this.games.add(game);
        this.notify();
    }

    createGame()
    {
        let g = new Game();
        g.setTitle($("#txt-title").val());
        g.setReleaseYear($("#txt-release-year").val());

        return g;
    }

    getGame(index)
    {
        return this.games.at(index);
    }

    getGames(){
        return this.games;
    }

    updateGame(index, game)
    {
        this.games.replace(index, game);
        this.notify();
    }

    removeGame(index)
    {
        this.games.remove(index);
        this.notify();
    }

}
