/* JS Document */

/******************************

[Table of Contents]

1. Vars and Inits
2. Set Header
3. Init Search
4. Init Menu
5. Init Quantity


******************************/

$(document).ready(function()
{
	"use strict";

	/* 

	1. Vars and Inits

	*/

	var header = $('.header');
	var hambActive = false;
	var menuActive = false;

	setHeader();

	$(window).on('resize', function()
	{
		setHeader();
	});

	$(document).on('scroll', function()
	{
		setHeader();
	});

	initSearch();
	initMenu();
	initQuantity();

	/* 

	2. Set Header

	*/

	function setHeader()
	{
		if($(window).scrollTop() > 100)
		{
			header.addClass('scrolled');
		}
		else
		{
			header.removeClass('scrolled');
		}
	}

	/* 

	3. Init Search

	*/

	function initSearch()
	{
		if($('.search').length && $('.search_panel').length)
		{
			var search = $('.search');
			var panel = $('.search_panel');

			search.on('click', function()
			{
				panel.toggleClass('active');
			});
		}
	}

	/* 

	4. Init Menu

	*/

	function initMenu()
	{
		if($('.hamburger').length)
		{
			var hamb = $('.hamburger');

			hamb.on('click', function(event)
			{
				event.stopPropagation();

				if(!menuActive)
				{
					openMenu();
					
					$(document).one('click', function cls(e)
					{
						if($(e.target).hasClass('menu_mm'))
						{
							$(document).one('click', cls);
						}
						else
						{
							closeMenu();
						}
					});
				}
				else
				{
					$('.menu').removeClass('active');
					menuActive = false;
				}
			});

			//Handle page menu
			if($('.page_menu_item').length)
			{
				var items = $('.page_menu_item');
				items.each(function()
				{
					var item = $(this);

					item.on('click', function(evt)
					{
						if(item.hasClass('has-children'))
						{
							evt.preventDefault();
							evt.stopPropagation();
							var subItem = item.find('> ul');
						    if(subItem.hasClass('active'))
						    {
						    	subItem.toggleClass('active');
								TweenMax.to(subItem, 0.3, {height:0});
						    }
						    else
						    {
						    	subItem.toggleClass('active');
						    	TweenMax.set(subItem, {height:"auto"});
								TweenMax.from(subItem, 0.3, {height:0});
						    }
						}
						else
						{
							evt.stopPropagation();
						}
					});
				});
			}
		}
	}

	function openMenu()
	{
		var fs = $('.menu');
		fs.addClass('active');
		hambActive = true;
		menuActive = true;
	}

	function closeMenu()
	{
		var fs = $('.menu');
		fs.removeClass('active');
		hambActive = false;
		menuActive = false;
	}

	/* 

	5. Init Quantity

	*/

	function initQuantity()
	{
            // Handle product quantity input
            if($('.product_quantity').length) {
                
                var product_id;
                
                $('.quantity_control').on('click', function() {
                    var $button = $(this);
                    var input = $button.parent().find('.inValue').val();
                    product_id = $button.parent().find('.product_id').val();
                    var originalVal;
                    var endVal;
                    
                    if ($button.text() == "+") {
                        originalVal = input;
			endVal = parseFloat(originalVal) + 1;
                    } else {
                    // Don't allow decrementing below zero
                        originalVal = input;
                        if (originalVal > 1) {
                            endVal = parseFloat(originalVal) - 1;
                        } else {
                            endVal = 1;
                        }
                    }
                        $button.parent().find('.inValue').val(endVal);
                        
                        console.log(endVal);
                        console.log(product_id);
                        
                        $.ajax({
                            type: "POST",
                            cache: false,
                            url: "update_item.jsp",
                            data: {
                                "product_id": product_id,
                                "qty": endVal,
                            },
                            success: function() {
                                $button.parent().find('.inValue').val(endVal);
                            }
                        });
                });
            }
	}

});