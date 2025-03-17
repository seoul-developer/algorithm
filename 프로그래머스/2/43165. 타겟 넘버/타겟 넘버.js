function solution(numbers, target) {
    let answer = 0;
    let result_arr = []
    numbers.forEach((number) => {
        let result_arr_temp = []
        if(result_arr.length == 0) {
            result_arr_temp = [number, -number]
        } else {
            result_arr.forEach((result_item) => {
                result_arr_temp.push(result_item + number)
                result_arr_temp.push(result_item - number)
            })
        }
        result_arr = result_arr_temp
    })
    result_arr.forEach((number) => {
        if(number == target) {
            answer = answer + 1
        }
    })
    return answer;
}