function createEmployeeCard(employeeObj) {
    let innerFlex = document.createElement("div");
    innerFlex.classList.add("d-flex", "align-items-center", "col-md-7", "col-10", "m-1");

    let cardDiv = document.createElement("div");
    innerFlex.append(cardDiv);
    cardDiv.classList.add("d-flex", "col-12", "profile-card");

    //*** 左半分 ***
    const leftInfo = document.createElement("div");
    leftInfo.classList.add("col-8", "py-3");
    const div1 = document.createElement("div");
    div1.classList.add("py-2")
    const div2 = div1.cloneNode(true);
    const div3 = div1.cloneNode(true);

    const nameTitle = document.createElement("h4");
    nameTitle.innerHTML = employeeObj.getFullName();

    const employeeJob = document.createElement("p")
    const employeeSkill = document.createElement("p")
    const employeeCountry = document.createElement("p");

    employeeJob.innerHTML = "Job: " + "<br>" + employeeObj.job;
    div1.append(employeeJob);

    employeeSkill.innerHTML = "Skill: " + "<br>" + employeeObj.skills;
    div2.append(employeeSkill);

    employeeCountry.innerHTML = "Country : " + "<br>" + employeeObj.country;
    div3.append(employeeCountry);

    leftInfo.append(nameTitle);
    leftInfo.append(div1);
    leftInfo.append(div2);
    leftInfo.append(div3);
    //*** 左半分終了 ***

    //*** 右半分 ***
    const rightInfo = document.createElement("div");
    const div4 = document.createElement("div");
    rightInfo.classList.add("col-4", "d-flex", "justify-content-center", "align-items-center");
    const avatar = document.createElement("img");
    avatar.classList.add("avatar");
    avatar.src = employeeObj.avatarUrl;
    div4.append(avatar);
    rightInfo.append(div4);
    //*** 右半分終了 ***

    cardDiv.append(leftInfo);
    cardDiv.append(rightInfo);

    return innerFlex;
}

const profileDiv = document.getElementById("profiles");

// クラス
class Employee {
    constructor(firstName, lastName, job, skills, country, avatarUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.skills = skills;
        this.country = country;
        this.avatarUrl = avatarUrl;
    }

    getFullName() {
        return this.firstName + " " + this.lastName;
    }
}

const employeeObj1 = new Employee("Kaiden", "Herman", "Software Engineer", "C++, C#, Java, PHP, JavaScript, Python", "United States", "https://pbs.twimg.com/profile_images/501759258665299968/3799Ffxy.jpeg");
const employeeObj2 = new Employee("Elizabeth", "Dunn", "Accountant", "Excel, Word, Quickbooks", "England", "https://randomuser.me/api/portraits/women/76.jpg");
const employeeObj3 = new Employee("Duan" ,"Moreno", "Teacher", "Working with children, History, Word", "Argentina", "https://randomuser.me/api/portraits/med/men/93.jpg");

profileDiv.append(createEmployeeCard(employeeObj1));
profileDiv.append(createEmployeeCard(employeeObj2));
profileDiv.append(createEmployeeCard(employeeObj3));


