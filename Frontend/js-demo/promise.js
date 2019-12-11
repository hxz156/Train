// Promise 
// solve callback hell

// use PROMISE TO EXECUTE asynchronous operation
// Promise status: pending, resolved, rejected
// var promise = new Promise(function(resolve, reject) {
//     setTimeout(function() {
//         if (Math.random() > 0.5) {
//             console.log('exam is created');
//             resolve(); // change promise to resolved status
//         } else {
//             console.log('no exam');
//             reject();
//         }
//     }, 1000);
// });
// register callback functions regarding of Promise status
// promise.then(function() { // success callback
//     console.log('ready to take exam!');
// }, function() { // failure callback
//     console.log('dismiss!');
// });

//=============================================================================

createExam().then(function() {
    console.log('ready to take!');
    return takeExam();
}, function() {
    console.log('dismiss!');

    // 默认的 return:
    // return new Promise(function(resolve, reject) {
    //     resolve();
    // });
    // no way to break promise chain

    throw new Error(); // failure callback execute auto
                
}).then(function() {
    console.log('pass exam');
}, function() {
    if (data instanceof Error) {
        
    } else {
        console.log('prepare for take');
    }
});


function createExam() {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            if (Math.random() > 0.5) {
                console.log('exam is created');
                resolve();
            } else {
                console.log('no exam');
                reject();
            }
        }, 1000);
    });
}
function takeExam() {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            if (Math.random() > 0.5) {
                console.log('good');
                resolve();
            } else {
                console.log('prepare for retake');
                reject();
            }
        }, 1000);
    });
}
function retakeExam() {
    return new Promise(function(resolve, reject) {
        setTimeout(function() {
            if (Math.random() > 0.5) {
                console.log('pass retake');
                resolve();
            } else {
                console.log('fail retake');
                reject();
            }
        }, 1000);
    });
}



//=============================================================================
// call back
// call back hell
// setTimeout(function() {
//     if (Math.random() > 0.5) {
//         console.log('exam is created');
//         set2();
//     } else {
//         console.log('no exam');
//     }
// }, 1000);

// function set2() {
//     setTimeout(function() {
//         if (Math.random() > 0.5) {
//             console.log('pass exam');
//         } else {
//             console.log('fail exam');    
//             set3();           
//         }
//     }, 2000);
// }

// function set3() {
//     setTimeout(function() {
//         if (Math.random() > 0.5) {
//             console.log('pass retake');
//         } else {
//             console.log('fail retake');
//         }
//     }, 3000);
// }





