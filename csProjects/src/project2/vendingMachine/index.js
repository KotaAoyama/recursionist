// const targetComponents = {
//     selectedInfoContainer: document.getElementById("selectedItemContainer"),
//     buttonsContainer: document.getElementById("numBtnContainer"),
// }

class Animal {
    constructor(name, price, imgUrl) {
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}

const animals = [
    new Animal("Tiger", "$100", "https://cdn.pixabay.com/photo/2015/12/18/13/46/tiger-1098607__340.jpg"),
    new Animal("Elephant", "$200", "https://cdn.pixabay.com/photo/2016/11/14/04/45/elephant-1822636__480.jpg"),
    new Animal("Parrot", "$30", "https://cdn.pixabay.com/photo/2018/09/22/17/05/parrot-3695678__340.jpg"),
    new Animal("Cheetah", "$190", "https://cdn.pixabay.com/photo/2018/06/14/22/22/cheetah-3475778__340.jpg"),
    new Animal("Panda", "$90", "https://cdn.pixabay.com/photo/2019/08/21/16/03/panda-4421395__340.jpg"),
    new Animal("Ibis", "$75", "https://cdn.pixabay.com/photo/2018/11/11/16/51/ibis-3809147__340.jpg")
];

class Controller {
    static slideJump(inputIndex) {
        const main = document.getElementById("main");
        let index = parseInt(main.getAttribute("data-index"));

        const currentElement = document.createElement("div");
        currentElement.classList.add("d-flex", "justify-content-center");


        animate(currentElement, nextElement, animationType);
    }

    static animate(currentElement, nextElement, animationType) {
        const main = document.getElementById("main");
        const extra = document.getElementById("extra");
        const sliderShow = document.getElementById("sliderShow");

        main.innerHTML = "";
        main.append(nextElement);

        extra.innerHTML = "";
        extra.append(currentElement);

        main.classList.add("expand-animation");
        extra.classList.add("deplete-animation");

        if (animationType == "right") {
            sliderShow.innerHTML = "";
            sliderShow.append(extra);
            sliderShow.append(main);
        } else if (animationType == "left") {
            sliderShow.innerHTML = "";
            sliderShow.append(main);
            sliderShow.append(extra);
        }
    }
}

class View {
    static createButtons() {
        const buttonsContainer = document.getElementById("buttonsContainer");
        const innerFlexDiv = buttonsContainer.firstElementChild;

        animals.forEach((animal, i) => {
            const col3Div = document.createElement("div");
            col3Div.classList.add("col-3", "text-center", "px-2", "py-2");

            const button = document.createElement("button");
            button.classList.add("btn", "btn-light", "col-12");
            button.innerHTML = (i + 1).toString();

            col3Div.append(button);
            innerFlexDiv.append(col3Div);
        })

        const buttons = buttonsContainer.querySelectorAll(".btn");
        animals.forEach((animal, i) => {
            buttons[i].addEventListener("click", function () {
                Controller.slideJump(i + 1);
            })
        })
    }
}

View.createButtons();