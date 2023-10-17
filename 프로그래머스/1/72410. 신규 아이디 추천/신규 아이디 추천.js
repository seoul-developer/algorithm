function checkCharacter(id){
    var temp = ""
    for(var c of id) {
        if(c.match(new RegExp(/^[a-z]/)) !== null || c.match(new RegExp(/^[0-9]/)) !== null || c.match(new RegExp(/^[-_.]/)) !== null){
            temp = temp + c;
        }
    }
    return temp
}

function checkDots(id){
    var temp = id[0];
    for(var i = 1; i < id.length; i++) {
        if(!(id[i-1] =="." && id[i] ==".")) {
            temp = temp + id[i];
        }
    }
    return temp
}

function checkDotPosition(id) {
    if (id[0] == ".") {
        id = id.slice(1)
    }
    if (id[id.length-1] == ".") {
        id = id.slice(0,-1)
    }
    
    return id
}

function checkEmpty(id) {
    if (id == "") {
        id = "a"
    }
    return id
}

function checkMaxLength(id) {
    if (id.length > 15) {
        id = id.slice(0,15);
        id = checkDotPosition(id);
    }
    
    return id
}

function checkMaxLength(id) {
    if (id.length > 15) {
        id = id.slice(0,15);
        id = checkDotPosition(id);
    }
    
    return id
}

function checkMinLength(id) {
    while (id.length < 3) {
        id = id + id[id.length-1];
    }
    
    return id
}

function verifyID(new_id, step) {
    if(step == 1) {
        new_id = new_id.toLowerCase();
    }
    
    if(step == 2) {
        new_id = checkCharacter(new_id);
    }
    
    if(step == 3) {
        new_id = checkDots(new_id);
    }
    
    if(step == 4) {
        new_id = checkDotPosition(new_id);
    }
    
    if(step == 5) {
        new_id = checkEmpty(new_id);
    }
    
    if(step == 6) {
        new_id = checkMaxLength(new_id);
    }
    
    if(step == 7) {
        new_id = checkMinLength(new_id);
    }
    
    return new_id
}

function solution(new_id) {
    for(var step = 1; step<8; step++) {
        new_id = verifyID(new_id, step);
        console.log(new_id)
    }
    return new_id;
}