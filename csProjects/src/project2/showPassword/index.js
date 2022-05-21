function passwordToggle(){
    const pass = document.getElementById("passwordClick");
    pass.type = pass.type === "password" ? "text" : "password";
}

function lockPassword() {
    const passwordInput = document.getElementById('passwordClick');
    passwordInput.disabled = true;

    if(passwordInput.value === "") return;

    const p = document.createElement('p');
    const lockedPasswordDiv = document.getElementById('lockedPassDiv') ;
    p.append(passwordInput.value);

    let saved = passwordInput.value;
    p.addEventListener('mouseover', function () {
        p.innerText = saved;
    })
    p.addEventListener('mouseout', function() {
        p.innerText = "*".repeat(p.innerText.length);
    })

    passwordInput.value = "";
    lockedPasswordDiv.append(p);
}

