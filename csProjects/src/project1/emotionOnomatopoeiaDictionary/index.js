class Word{
    constructor(word, definition, pictureUrl){
        this.word = word;
        this.definition = definition;
        this.pictureUrl = pictureUrl;
    }
}

class EmotionObject{
    constructor(emotion, description, color, onomatopoeia, emoji){
        this.emotion = emotion;
        this.description = description;
        this.color = color;
        this.onomatopoeia = onomatopoeia;
        this.emoji = emoji;
    }

    getOnomatopoeiaWords(){
        return this.onomatopoeia.map(word => new Word(word, dictionary[word], pictureDictionary[word]));
    }

}

//グローバル定数
const dictionary = {
    "bark":"the sound made by a dog",
    "grunt":"issue a low, animal-like noise",
    "roar":"make a loud noise, as of an animal",
    "whack":"the act of hitting vigorously",
    "smack":"a blow from a flat object (as an open hand)",
    "hiss":`make a sharp, elongated "s" sound`,
    "ahem":"the utterance of a sound similar to clearing the throat",
    "bawl":"cry loudly",
    "bling":"flashy, ostentatious jewelry",
    "boom":"a deep prolonged loud noise",
    "buzz":"the sound of rapid vibration",
    "caw":"utter a cry, characteristic of crows, rooks, or ravens",
    "chatter":"talk socially without exchanging too much information",
    "chant":"a repetitive song in which syllables are assigned to a tone",
    "clatter":"a continuous rattling sound as of hard objects falling or striking each other.",
    "clunk":"a heavy dull sound (as made by impact of heavy objects)",
    "crawl":"move forward on the hands and knees or by dragging the body close to the ground.",
    "flick":"throw or toss with a quick motion",
    "giggle":"a light, silly laugh.",
    "gargle":"an act or instance or the sound of washing one's mouth and throat with a liquid kept in motion by exhaling through it.",
    "honk":"the cry of a goose or any loud sound resembling it",
    "oink":"the short low gruff noise of the kind made by hogs",
    "whine":"a complaint uttered in a plaintive way",
    "waah":"sound made when crying by babies",
    "zing":"sound my by something energetic"
};

const pictureDictionary = {
    "bark":"https://cdn.pixabay.com/photo/2013/07/25/11/59/german-shepherd-166972_1280.jpg",
    "grunt":"https://cdn.pixabay.com/photo/2010/11/29/nepal-419__480.jpg",
    "roar":"https://cdn.pixabay.com/photo/2018/04/13/21/24/lion-3317670_1280.jpg",
    "whack":"https://cdn.pixabay.com/photo/2017/10/27/11/49/boxer-2894025_1280.jpg",
    "smack":"https://cdn.pixabay.com/photo/2015/03/20/19/38/hammer-682767_1280.jpg",
    "hiss":"https://cdn.pixabay.com/photo/2016/10/13/23/30/cat-1739091_1280.jpg",
    "ahem":"https://cdn.pixabay.com/photo/2014/03/13/10/12/man-286476_1280.jpg",
    "bawl":"https://cdn.pixabay.com/photo/2015/06/26/10/17/smiley-822365_960_720.jpg",
    "bling":"https://cdn.pixabay.com/photo/2017/12/30/13/37/happy-new-year-3050088_1280.jpg",
    "boom":"https://cdn.pixabay.com/photo/2016/04/12/21/17/explosion-1325471_1280.jpg",
    "buzz":"https://cdn.pixabay.com/photo/2020/02/13/10/29/bees-4845211_1280.jpg",
    "caw":"https://cdn.pixabay.com/photo/2017/02/16/11/13/bird-2071185_1280.jpg",
    "chatter":"https://cdn.pixabay.com/photo/2014/07/25/08/55/bar-401546_1280.jpg",
    "chant":"https://cdn.pixabay.com/photo/2016/07/19/07/43/parchment-1527650__340.jpg",
    "clatter":"https://cdn.pixabay.com/photo/2020/02/06/19/01/clutter-4825256_1280.jpg",
    "clunk":"https://cdn.pixabay.com/photo/2017/01/10/03/06/steel-1968194_1280.jpg",
    "crawl":"https://cdn.pixabay.com/photo/2017/11/23/07/47/baby-2972221__340.jpg",
    "flick":"https://cdn.pixabay.com/photo/2012/02/23/08/48/disgust-15793_1280.jpg",
    "giggle":"https://cdn.pixabay.com/photo/2017/08/07/15/18/people-2604850_1280.jpg",
    "gargle":"https://cdn.pixabay.com/photo/2017/04/03/16/32/girl-smoke-cigarette-2198839_1280.jpg",
    "honk":"https://cdn.pixabay.com/photo/2017/02/28/14/37/geese-2105918_1280.jpg",
    "oink":"https://cdn.pixabay.com/photo/2019/03/02/15/32/pig-4030013_1280.jpg",
    "whine":"https://cdn.pixabay.com/photo/2020/05/01/01/57/girl-5115192_960_720.jpg",
    "waah":"https://cdn.pixabay.com/photo/2017/01/18/02/18/emotions-1988745_1280.jpg",
    "zing":"https://cdn.pixabay.com/photo/2017/09/14/16/38/fiber-optic-2749588_1280.jpg"
};

const emotions = [
    new EmotionObject("angry", "feeling or showing strong annoyance, displeasure, or hostility; full of anger.", "red", ["bark","grunt", "roar","whack","smack","hiss"], "😠"),
    new EmotionObject("happy", "feeling or showing pleasure or contentment.", "pink", ["bling","chatter","chant","giggle"], "🥳"),
    new EmotionObject("bad", "not such as to be hoped for or desired; unpleasant or unwelcome.", "lightblue", ["ahem","clatter","clunk"], "😰"),
    new EmotionObject("sad", "feeling or showing sorrow; unhappy.", "grey", ["bawl","whine","waah"], "🥺"),
    new EmotionObject("surprised", "to feel mild astonishment or shock.", "purple", ["boom","honk","zing"], "😲"),
    new EmotionObject("fearful", "feeling afraid; showing fear or anxiety.", "green", ["buzz","caw","crawl"], "😖"),
    new EmotionObject("disgusted", "feeling or showing strong annoyance, displeasure, or hostility; full of anger.", "orange", ["flick","gargle","oink"], "😒")
];

function getEmotionNav(emotions) {
    const containerDiv = document.createElement("div");
    containerDiv.classList.add("container", "d-flex", "justify-content-center", "flex-wrap");

    emotions.forEach(emotionObj => {
        const expandLinkDiv = document.createElement("div");
        expandLinkDiv.classList.add("expandLink", "col-12", "col-md-6", "col-lg-3", "p-4", "m-4", "text-center");
        expandLinkDiv.style.backgroundColor = emotionObj.color;

        const a = document.createElement("a");
        a.href = `#${emotionObj.emotion}`;

        const h3 = document.createElement("h3");
        h3.classList.add("text-white");
        h3.innerText = emotionObj.emotion;

        const h1 = document.createElement("h1");
        h1.innerText = emotionObj.emoji;

        const p = document.createElement("p");
        p.classList.add("text-white");
        p.innerText = emotionObj.description;

        expandLinkDiv.append(a, h3, h1, p);
        containerDiv.append(expandLinkDiv);

    });

    return containerDiv;
}

function getWords(emotionObj) {

    const wordObjArr = emotionObj.getOnomatopoeiaWords();

    const flexDiv = document.createElement("div");
    flexDiv.classList.add("d-flex", "justify-content-between", "flex-wrap");

    wordObjArr.forEach(wordObj => {
        const whiteDiv = document.createElement("div");
        whiteDiv.classList.add("d-flex", "col-12", "col-md-5", "bg-white", "my-2", "px-0");

        const col8Div = document.createElement("div");
        col8Div.classList.add("col-8");

        const h4 = document.createElement("h4");
        h4.classList.add("pt-3");
        h4.innerText = wordObj.word;

        const p = document.createElement("p");
        p.classList.add("pt-2");
        p.innerText = wordObj.definition;

        const col4Div = document.createElement("div");
        col4Div.classList.add("col-4", "px-0", "d-flex", "justify-content-center", "align-items-center");

        const img = document.createElement("img");
        img.classList.add("imgFit", "col-12", "p-1");
        img.src = wordObj.pictureUrl;

        col8Div.append(h4, p);
        col4Div.append(img);
        whiteDiv.append(col8Div, col4Div);

        flexDiv.append(whiteDiv);

    })

    return flexDiv;
}

function getEmotionCategories(emotions) {

    const outerDiv = document.createElement("div");

    emotions.forEach(emotionObj => {
        const colorDiv = document.createElement("div");
        colorDiv.style.backgroundColor = emotionObj.color;
        colorDiv.id = emotionObj.emotion;

        const containerDiv = document.createElement("div");
        containerDiv.classList.add("container", "py-3");

        const emotionHeaderDiv = document.createElement("div");
        emotionHeaderDiv.classList.add("p-3", "text-white");

        const h2 = document.createElement("h2");
        h2.innerText = emotionObj.emotion;

        const p = document.createElement("p");
        p.innerText = emotionObj.description;

        emotionHeaderDiv.append(h2, p);
        containerDiv.append(emotionHeaderDiv, getWords(emotionObj));
        colorDiv.append(containerDiv);

        outerDiv.append(colorDiv);

    });

    return outerDiv;
}

const target = document.getElementById("target");
target.append(getEmotionNav(emotions));
target.append(getEmotionCategories(emotions));
