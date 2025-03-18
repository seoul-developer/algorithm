function isValid(duration, agreeDate, today) {
    var [validYear, validMonth, validDate] = agreeDate;
    var [todayYear, todayMonth, todayDate] = today;
    
    validYear = parseInt(validYear);
    validMonth = parseInt(validMonth);
    validDate = parseInt(validDate);
    todayYear = parseInt(todayYear);
    todayMonth = parseInt(todayMonth);
    todayDate = parseInt(todayDate);
    duration = parseInt(duration);
    
    
    
    if(validDate==1){
        validDate = 28;
        validMonth -= 1;
    }else{
        validDate -= 1;
    }
    
    validMonth += duration;
    
    if(validMonth > 12){
        validYear += parseInt(validMonth/12);
        validMonth = validMonth%12;
    }
    
    if(validMonth == 0){
        validYear -= 1;
        validMonth = 12;
    }
    
    console.log(validYear, validMonth, validDate)
    
    if(todayYear > validYear){
        return false;
    }else if(todayYear == validYear && todayMonth > validMonth){
        return false;
    }else if(todayYear == validYear && todayMonth == validMonth && todayDate > validDate){
        return false;
    }else{
        return true;
    }
    
}

function solution(today, terms, privacies) {
    var terms_map = new Map();
    for(var i in terms){
        var [term, period] = terms[i].split(" ");
        terms_map.set(term, period);
    }
    
    var answer = [];
    
    
    for(var j in privacies){
        var agreeDate = privacies[j].split(" ")[0].split(".");
        var term = privacies[j].split(" ")[1];
        var duration = terms_map.get(term);
        if(!isValid(duration, agreeDate, today.split("."))){
            answer.push(parseInt(j)+1);
        }
    }
    
    return answer;
}