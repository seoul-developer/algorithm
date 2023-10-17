function solution(survey, choices) {
    var characters = ["R", "T", "C", "F", "J", "M", "A", "N"];
    var characterMap = new Map();
    for(var character of characters) {
        characterMap.set(character, 0);
    }
    for(var i in survey) {
        if(choices[i] > 4) {
            characterMap.set(survey[i][1], characterMap.get(survey[i][1])+choices[i]-4);
        }else if(choices[i] < 4){
            characterMap.set(survey[i][0], characterMap.get(survey[i][0])+4-choices[i]);
        }
    }
    
    var answer = '';
    
    if(characterMap.get("R") >= characterMap.get("T")) {
        answer = "R";
    }else {
        answer = "T";
    }
    
    if(characterMap.get("C") >= characterMap.get("F")) {
        answer += "C";
    }else {
        answer += "F";
    }
    
    if(characterMap.get("J") >= characterMap.get("M")) {
        answer += "J";
    }else {
        answer += "M";
    }
    
    if(characterMap.get("A") >= characterMap.get("N")) {
        answer += "A";
    }else {
        answer += "N";
    }
    
    return answer;
}