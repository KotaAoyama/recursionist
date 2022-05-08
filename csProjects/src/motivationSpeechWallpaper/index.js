function motivationalSpeechWallpaper(message, colorCode, imgSrcUrl, vertical, horizontal, domObj) {
    const position = {
        "left": "start",
        "center": "center",
        "right": "end",
        "top": "start",
        "bottom": "end"
    };

    const container = document.createElement("div");
    container.classList.add("container", "d-flex", "justify-content-center");

    const imgBackGroundDiv = document.createElement("div");
    imgBackGroundDiv.classList.add("vh-100", "col-12", "col-md-8", "p-3", "my-5", "d-flex", `justify-content-${position[horizontal]}`, `align-items-${position[vertical]}`);
    imgBackGroundDiv.style.backgroundImage = `url(${imgSrcUrl})`;
    imgBackGroundDiv.style.backgroundSize = "cover";
    imgBackGroundDiv.style.backgroundRepeat = "no-repeat";

    const innerDiv = document.createElement("div");
    innerDiv.classList.add("col-8");

    const h4 = document.createElement("h4");
    h4.style.color = `#${colorCode}`;
    h4.innerText = message;

    innerDiv.append(h4);
    imgBackGroundDiv.append(innerDiv);
    container.append(imgBackGroundDiv);
    domObj.append(container);

}


const domObj = document.getElementById("target");

motivationalSpeechWallpaper("Perfection is achieved, not when there is nothing more to add, but when there is nothing left to take away. - Antoine de Saint", "2c3e50", "https://cdn.pixabay.com/photo/2020/06/12/03/06/magnifying-glass-5288877__340.jpg", "center", "center", domObj);
motivationalSpeechWallpaper("The scientist discovers a new type of material or energy and the engineer discovers a new use for it. - Gordon Lindsay Glegg", "2c3e50", "https://cdn.pixabay.com/photo/2018/02/23/04/38/laptop-3174729_1280.jpg", "bottom", "left", domObj);
motivationalSpeechWallpaper("Scientists study the world as it is, engineers create the world that never has been. - Theodore von Karman", "ecf0f1", "https://cdn.pixabay.com/photo/2017/05/10/19/29/robot-2301646_1280.jpg", "top", "right", domObj);