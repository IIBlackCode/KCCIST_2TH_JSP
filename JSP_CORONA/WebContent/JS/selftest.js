function checkValidAnswer(form) {
    if (form.answer1.value == "") {
        document.getElementById('alert_answer1').innerText = "문항 체크가 되지 않았습니다.";
        // form.password.focus();
        return false;
    }

    const testAns = form.answer1.value;
    const tfAns =form.Tanswer.value

    if (testAns < 2) {
        // 최소 6문자.
        document.getElementById('alert_answer1').innerText = "검진 가능한 최소 문항수보다 덜 입력하셨습니다.";
        return false;
    } else if (testAns<4) {
        // 한글과 같은 문자열 입력 방지.
        document.getElementById('alert_password').innerText = "확진 확률이 80%입니다.";
        return false;
    } else if (tfAns=0) {
        // 한글과 같은 문자열 입력 방지.
        document.getElementById('alert_tfAnswer').innerText = "거짓으로 입력하셨습니다.";
        return false;
    }
    return true;
}

// $(document).ready(function() {
// $("#Register").click(function() {
// var checkbox_yes = document.getElementsByName("question");
// var count = 0;
// var i = 0;
//
// for (i = 0; i < checkbox_yes.length; i++) {
//
// if (checkbox_yes[i].checked == true) {
// count++;
// }
//
// if (count > 4) {
// location.href = "Inform.html";
// }
// }
// });
// });
