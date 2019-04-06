//set default degree (360*5)
var degree = 1800;
//number of clicks = 0
var clicks = 0;

$(document).ready(function(){

	/*WHEEL SPIN FUNCTION*/
	$('#spin').click(function(){

		//add 1 every click
		clicks ++;

		/*multiply the degree by number of clicks
	  generate random number between 1 - 360,
    then add to the new degree*/
		var newDegree = degree*clicks;
		var extraDegree = Math.floor(Math.random() * (360 - 1 + 1)) + 1;
		totalDegree = newDegree+extraDegree;

		/*let's make the spin btn to tilt every
		time the edge of the section hits
		the indicator*/
		$('#wheel .sec').each(function(){
			var t = $(this);
			var noY = 0;

			var c = 0;
			var n = 700;
			var interval = setInterval(function () {
				c++;
				if (c === n) {
					clearInterval(interval);
				}

				var aoY = t.offset().top;
				$("#txt").html(aoY);
				console.log(aoY);

				/*23.7 is the minumum offset number that
				each section can get, in a 30 angle degree.
				So, if the offset reaches 23.7, then we know
				that it has a 30 degree angle and therefore,
				exactly aligned with the spin btn*/
				if(aoY < 23.89){
					console.log('<<<<<<<<');
					$('#spin').addClass('spin');
					setTimeout(function () {
						$('#spin').removeClass('spin');
					}, 100);
				}
			}, 10);

			 $('#inner-wheel').css({
				'transform' : 'rotate(' + totalDegree + 'deg)'
			});

			noY = t.offset().top;

			// Hard-coded rooms in the order they appear in the wheel
			// [X] TODO: Get the wheel to land on the correct corresponding room with the slice it actually lands on.
			// NOTE: THESE NEED TO BE IN REVERSE ORDER!!!
			var rooms = ["Yard", "Bedroom", "Foyer", "Office", "Basement", "Bathroom", "Kitchen", "Living Room"];

			// This formula doesn't quite work for picking the correct room, but it is definitely the closest I've gotten.
			var divider = 360 / rooms.length; // built in for the next phase
			var offset = divider / 2; // half division since the pointer starts in the middle of a slice
			var wheelValue = rooms[Math.floor(Math.ceil((totalDegree + offset) % 360) / divider)];

			// Once the inner wheel stops moving...
			$('#inner-wheel').one('transitionend', function() {

			    // change the color and contents of the toDoModal
			    if (wheelValue === "Living Room") {
			        $(".roomSelect").css("color", "#D54227");
			        $(".roomSelect").html("Living Room");
			    } else if (wheelValue === "Kitchen") {
			        $(".roomSelect").css("color", "#C0702B");
			        $(".roomSelect").html("Kitchen");
			    } else if (wheelValue === "Bathroom") {
			        $(".roomSelect").css("color", "#C98F2A");
			        $(".roomSelect").html("Bathroom");
			    } else if (wheelValue === "Basement") {
			        $(".roomSelect").css("color", "#898E36");
			        $(".roomSelect").html("Basement");
			    } else if (wheelValue === "Office") {
			        $(".roomSelect").css("color", "#138D6C");
			        $(".roomSelect").html("Office");
			    } else if (wheelValue === "Foyer") {
			        $(".roomSelect").css("color", "#81B999");
			        $(".roomSelect").html("Foyer");
			    } else if (wheelValue === "Bedroom") {
			        $(".roomSelect").css("color", "#926C6C");
			        $(".roomSelect").html("Bedroom");
			    } else if (wheelValue === "Yard") {
			        $(".roomSelect").css("color", "#D67260");
			        $(".roomSelect").html("Yard");
			    }

			    $('#toDoModal').modal('show');

			});

            // Modal Button Clicking Changes
            $(function () {

                $(".doneModal").click(function() {

                    $("#doneModal").modal();

                });

                $(".wheelReset").click(function() {

                    $("#inner-wheel").removeAttr('style');

                });

            });

		});
	});



});//DOCUMENT READY