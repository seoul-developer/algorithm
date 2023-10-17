function solution(id_list, report, k) {
    const set = new Set(report);
    report = [...set];
    var suedUser = new Map();
    var suerList = new Map();
    suedUser = suedMap(report);
    suerList = checkSuer(report);
    
    var result = [];
    
    result = getResult(suedUser, suerList, id_list, k);
    
    var answer = result;
    return answer;
}

function suedMap(report) {
    var tempMap = new Map();
    for(var line of report) {
        var suedPerson = line.split(" ")[1];
        if(!tempMap.has(suedPerson)) {
            tempMap.set(suedPerson, 1);
        }else {
            tempMap.set(suedPerson, tempMap.get(suedPerson) + 1);
        }
    }
    
    return tempMap
}

function checkSuer(report) {
    var tempMap = new Map();
    for(var line of report) {
        var suer = line.split(" ")[0];
        var suedPerson = line.split(" ")[1];
        if(!tempMap.has(suedPerson)) {
            tempMap.set(suedPerson, suer);
        }else {
            var suerArr = tempMap.get(suedPerson);
            tempMap.set(suedPerson, suerArr+ " " + suer);
        }
    }
    
    return tempMap
}

function getResult(suedUser, suerList, id_list, k) {
    var idMap = new Map();
    var resultArr = [];
    for(var id of id_list) {
        idMap.set(id, 0);
    }
    for(var id of id_list) {
        if(suedUser.get(id) >= k) {
            var suer_list = suerList.get(id).split(" ");
            for(var suer of suer_list) {
                idMap.set(suer, idMap.get(suer)+1);
            }
        }
    }
    for(var id of id_list) {
        resultArr.push(idMap.get(id));
    }
    
    return resultArr;
}