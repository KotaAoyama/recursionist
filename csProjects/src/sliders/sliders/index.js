const target = document.getElementById("target");

const sliderItems = document.querySelectorAll("#target .slider-data .slider-item");

console.log(sliderItems);
console.log(sliderItems[0]);

const sliderShow = document.createElement("div");
const main = document.createElement("div");
const extra = document.createElement("div");

sliderShow.classList.add("col-12", "d-flex", "flex-nowrap", "overflow-hiddens");
main.classList.add("main", "full-width");
extra.classList.add("extra", "full-width");

main.append(sliderItems[0]);

sliderShow.append(main);
sliderShow.append(extra);
target.append(sliderShow);