/// dir = [0, 1, 2, 3] => [E S W N]

function solution(grid) {
    var routeSet = new Set();
    var skipSet = new Set();
    for(var i = 0; i < grid.length; i++) {
        for(var j = 0; j < grid[0].length; j++) {
            for(var dir of [0, 1, 2, 3]) {
                if(skipSet.has([[i,j],dir].toString())){
                    continue;
                }
                var pos = [i,j];
                var posDirSet = new Set();
                var setSizeBefore = 0;
                var hangOn = true;
                while(hangOn) {
                    var resultSet = BEAM(grid, pos, dir);
                    skipSet.add(resultSet.toString());
                    posDirSet.add(resultSet.toString());
                    pos = resultSet[0];
                    dir = resultSet[1];
                    var setSizeAfter = posDirSet.size;
                    if(setSizeAfter == setSizeBefore) {
                        hangOn = false;
                    }
                    setSizeBefore = setSizeAfter;
                }
                var posDirSetArr = Array.from(posDirSet);
                posDirSetArr.sort();
                routeSet.add(posDirSetArr.join('-'));
            }
        }
    }
    var answer = [];
    for (var route of routeSet) {
      answer.push(route.split('-').length);
    }
    answer.sort(function(a, b) {
        return a - b;
    });
    return answer;
}


function BEAM(grid, inPos, inDir) {
    var outDir = changeDir(grid, inPos, inDir);
    var outPos = inPos;
    if(outDir == 0) {
        outPos[1] += 1;
    }else if(outDir == 1) {
        outPos[0] += 1;
    }else if(outDir == 2) {
        outPos[1] -= 1;
    }else if(outDir == 3) {
        outPos[0] -= 1;
    }
    
    outPos = checkLimit(outPos, grid);
    
    return [outPos, outDir]
}

function changeDir(grid, inPos, dir) {
    var charactor = grid[inPos[0]][inPos[1]];
    if(charactor == "S") {
        dir = dir;
    }else if(charactor == "L") {
        dir = (dir + 3) % 4;
    }else if(charactor == "R") {
        dir = (dir + 1) % 4;
    }else{
        throw new Error();
    }
    
    return dir;
}

function checkLimit(pos, grid) {
    if(pos[0] >= grid.length) {
        pos[0] = 0;
    }
    if(pos[1] >= grid[0].length) {
        pos[1] = 0;
    }
    if(pos[0] < 0) {
        pos[0] = grid.length - 1;
    }
    if(pos[1] < 0) {
        pos[1] = grid[0].length - 1;
    }

    return pos;
}