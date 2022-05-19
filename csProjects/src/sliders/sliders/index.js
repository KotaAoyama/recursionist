const target = document.getElementById("target");
const sliderItems = document.querySelectorAll("#target .slider-data .slider-item");

const sliderShow = document.createElement("div");
const main = document.createElement("div");
const extra = document.createElement("div");

sliderShow.classList.add("col-12", "d-flex", "flex-nowrap", "overflow-hidden");
main.classList.add("main", "full-width");
extra.classList.add("extra", "full-width");

main.append(sliderItems[0]);

sliderShow.append(main);
sliderShow.append(extra);
target.append(sliderShow);

const controls = document.createElement("div");
controls.classList.add("offset-5", "mt-2");

const leftBtn = document.createElement("button");
leftBtn.classList.add("btn", "btn-light");
leftBtn.innerHTML = "<";

const rightBtn = document.createElement("button");
rightBtn.classList.add("btn", "btn-light");
rightBtn.innerHTML = ">";

controls.append(leftBtn);
controls.append(rightBtn);
target.append(controls);

main.setAttribute("data-index", "0");

function slideJump(steps) {
    let index = parseInt(main.getAttribute("data-index"));
    const currentElement = sliderItems.item(index);

    index += steps;

    if(index < 0) index = sliderItems.length -1;
    else if(index >= sliderItems.length) index = 0;

    const nextElement = sliderItems.item(index);

    main.setAttribute("data-index", index.toString());
}

function animateMain(currentElement, nextElement, animationType) {
    extra.innerHTML = "";
    extra.append(currentElement);

    main.innerHTML = "";
    main.append(nextElement);

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

animateMain(sliderItems[2], sliderItems[3], "right");
// animateMain(sliderItems[0], sliderItems[4], "left");
