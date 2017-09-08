var reduce = function(key, values){
    var maxPrice = 1;
    var res = {};
    values.forEach(function(value){
      if(value.price >= maxPrice){
        maxPrice = value.price;
      }
    });  
    res.maxPrice = maxPrice;
    return res;
}