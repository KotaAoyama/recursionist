const target = document.getElementById("target");

const sliderItems = document.querySelectorAll("#target .slider-data .slider-item");

console.log(sliderItems);
console.log(sliderItems[0]);

const sliderShow = document.createElement("div");
const main = document.createElement("div");
const extra = document.createElement("div");
const arrows = document.createElement("div");
const left = document.createElement("button");
const right = document.createElement("button");

sliderShow.classList.add("col-12", "d-flex", "flex-nowrap", "overflow-hidden");
main.classList.add("main", "full-width");
extra.classList.add("extra", "full-width");
arrows.classList.add("offset-5", "mt-2");
left.classList.add("btn", "btn-light");
left.innerText = "<";
right.classList.add("btn", "btn-light");
right.innerText = ">";

main.append(sliderItems[0]);

sliderShow.append(main);
sliderShow.append(extra);
target.append(sliderShow);

arrows.append(left, right);
target.append(arrows);
