function passwordToggle(){
    const pass = document.getElementById("passwordClick");
    pass.type = pass.type === "password" ? "text" : "password";
}

function lockPassword() {
    const passwordInput = document.getElementById('passwordClick');
    passwordInput.disabled = true;

    const p = document.createElement('p');
    const lockedPasswordDiv = document.getElementById('lockedPassDiv') ;
    p.append(passwordInput.value);
    lockedPasswordDiv.append(p);
}