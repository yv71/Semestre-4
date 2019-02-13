/**
 * View of the Web application
 */
class View extends Observer
{
    /**
     * Constructor
     */
    constructor(c)
    {
        super();
        this.controleur = c;
        this.controleur.addObserver(this);
        $("#btn-add").on("click", () => { this.clicAdd(); })
        $("#btn-update").on("click", () => {
            let g = new Game();
            g.setTitle($("#txt-title").val());
            g.setReleaseYear($("#txt-release-year").val());
            this.controleur.updateGame(this.getSelectionIndex(), g);
        });
        $("#btn-remove").on("click", () => { this.controleur.removeGame(this.getSelectionIndex()) })
    }

    notify()
    {
        this.refreshList();
    }

    clicAdd()
    {
        let g = this.controleur.createGame();
        this.controleur.addGame(g);
    }

    refreshList()
    {
        let games = this.controleur.getGames();
        $("list").html("");
        games.forEach( (elt) => {
            let ne = document.createElement("div");
            ne.classList.add("game");
            let p = document.createElement("p");
            p.classList.add("title");
            p.innerHTML = elt.getTitle();
            ne.appendChild(p);
            p = document.createElement("p");
            p.classList.add("info");
            p.innerHTML = elt.getReleaseYear();
            ne.appendChild(p);
            $("list").append(ne);
            ne.addEventListener("click", () => {
                this.displayGame(elt);
                $(".selected").removeClass("selected");
                ne.classList.add("selected");
            })
        });
    }

    displayGame(game)
    {
        $("#txt-title").val(game.getTitle());
        $("#txt-release-year").val(game.getReleaseYear());
    }

    getSelectionIndex()
    {
        let item = $(".selected");
        let index = $(".game").index(item);

        return index;
    }

}
