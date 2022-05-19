const target = document.getElementById("target");

const sliderItems = document.querySelectorAll("#target .slider-data .slider-item");
let index = 0;
// console.log(sliderItems);
// console.log(sliderItems[index]);

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

// 現在のindexにdata-indexを設定します。
// setAttribute(属性名, 属性値)
main.setAttribute("data-index", "0");

// 1か-1を受け取って次の要素を設定するslideJumpという関数を作成します。
function slideJump(steps) {
    // 現在のindexを取得します。
    let index = parseInt(main.getAttribute("data-index"));
    // 現在の要素
    let currentElement = sliderItems.item(index);

    // 受け取ったstepに応じてindexを変化させます。
    index += steps;
    console.log(index);

    // 周回させるように
    if(index < 0) index = sliderItems.length -1;
    else if(index >= sliderItems.length) index = 0;

    // 上でindexがstepによって更新されているので、次の要素を設定します。
    let nextElement = sliderItems.item(index);

    // コンソールで確認
    console.log(currentElement);
    console.log(nextElement);

    // indexが更新されたのでdata-indexの更新
    main.setAttribute("data-index", index.toString());
}

// blue-gray-success-yellow-redで並んでいます。
slideJump(1);　//blue, grayが出力されます
slideJump(-1); //gray, blueが出力されます