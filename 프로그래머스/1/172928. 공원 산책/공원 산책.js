function findStartingPoint(park, mapSize) {
    var startingPoint;
    for(var i = 0; i < mapSize[0]; i++){
        for(var j = 0; j < mapSize[1]; j++){
            if(park[i][j]=="S"){
                startingPoint = [i,j]
            }
        }
    }
    
    return startingPoint
}

function checkOversize(pointNow, mapSize, direction, distance) {
    if(direction == "E") {
        if(pointNow[1]+distance >= mapSize[1]){
            return true
        }
    }else if(direction == "S"){
        if(pointNow[0]+distance >= mapSize[0]){
            return true
        }
    }else if(direction == "W"){
        if(pointNow[1]-distance < 0){
            return true
        }
    }else if(direction == "N"){
        if(pointNow[0]-distance < 0){
            return true
        }
    }else{
        throw new Error("Direction Error");
    }
}

function checkObstacle(pointNow, park, mapSize, direction, distance) {
    if(direction == "E") {
        for(var i =0; i < mapSize[1]; i++){
            if(park[pointNow[0]][i] == "X" && i > pointNow[1] && i <= pointNow[1] + distance){
                return true;
            }
        }
        return false
    }else if(direction == "S"){
        for(var j =0; j < mapSize[0]; j++){
            if(park[j][pointNow[1]] == "X" && j > pointNow[0] && j <= pointNow[0] + distance){
                return true;
            }
        }
        return false
    }else if(direction == "W"){
        for(var i =0; i < mapSize[1]; i++){
            if(park[pointNow[0]][i] == "X" && i < pointNow[1] && i >= pointNow[1] - distance){
                return true;
            }
        }
        return false
    }else if(direction == "N"){
        for(var j =0; j < mapSize[0]; j++){
            if(park[j][pointNow[1]] == "X" && j < pointNow[0] && j >= pointNow[0] - distance){
                return true;
            }
        }
        return false
    }else{
        throw new Error("Direction Error");
    }
}

function isMovable(pointNow, park, mapSize, direction, distance) {
    if(checkOversize(pointNow, mapSize, direction, distance) || checkObstacle(pointNow, park, mapSize, direction, distance)) {
        return false;
    }
    return true;
}

function moveDisDir(pointNow, direction, distance) {
    var newPoint = pointNow;
    if(direction == "E") {
        newPoint[1] = parseInt(newPoint[1]) + parseInt(distance);
    }else if(direction == "S") {
        newPoint[0] = parseInt(newPoint[0]) + parseInt(distance);
    }else if(direction == "W") {
        newPoint[1] = parseInt(newPoint[1]) - parseInt(distance);
    }else if(direction == "N") {
        newPoint[0] = parseInt(newPoint[0]) - parseInt(distance);
    }else{
        throw new Error("Direction Error");
    }
    
    return newPoint
}

function move(pointNow, park, attempt, mapSize) {
    var direction = attempt.split(" ")[0];
    var distance = parseInt(attempt.split(" ")[1]);
    var newPoint = pointNow;
    if(isMovable(pointNow, park, mapSize, direction, distance)){
        newPoint = moveDisDir(pointNow, direction, distance);
    }
    
    return newPoint;
    
}

function movePoint(startingPoint, park, routes, mapSize) {
    var pointNow = startingPoint;
    for(var attempt of routes){
        pointNow = move(pointNow, park, attempt, mapSize);
    }
    
    return pointNow;
}

function solution(park, routes) {
    var mapSize = [park.length, park[0].length];
    var startingPoint = findStartingPoint(park, mapSize);
    var result = movePoint(startingPoint, park, routes, mapSize);
    
    var answer = result;
    console.log(answer)
    return answer;
}