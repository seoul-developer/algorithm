function updateAnswer(answer, curX, curY){
    if(curX < answer[0]){
        answer[0] = curX;
    }
    if(curY < answer[1]){
        answer[1] = curY;
    }
    if(curX+1 > answer[2]){
        answer[2] = curX+1;
    }
    if(curY+1 > answer[3]){
        answer[3] = curY+1;
    }
    
    return answer
}

function solution(wallpaper) {
    var answer = [wallpaper.length, wallpaper[0].length, 0, 0 ]
    var curX = -1;
    var curY = 0;
    for(var line of wallpaper) {
        curX++;
        curY = 0;
        for(var i in line){
            if(line[i] == "#"){
                answer = updateAnswer(answer, curX, curY);
            }
            curY++;
        }
    }
    return answer;
}