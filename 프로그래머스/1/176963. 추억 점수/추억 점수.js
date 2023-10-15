function getScore(map, people){
    var score = 0;
    for(var person of people){
        if(map.get(person) != null){
            score += map.get(person);
        }
    }
    return score;
}

function solution(name, yearning, photo) {
    var map = new Map();
    for(i in name){
        map.set(name[i],yearning[i]);
    }
    
    var answer = [];
    
    for(var people of photo){
        var score = getScore(map, people);
        answer.push(score);
    }    
    return answer;
}