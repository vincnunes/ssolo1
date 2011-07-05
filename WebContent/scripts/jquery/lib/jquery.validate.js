(function($){  
	$.fn.validate = function(options) {  
		var defaults = {  
			cssClass: 'invalid'
		};
		var options = $.extend(defaults, options); 
		return this.each(function() {  
			var o = $(this);
			o.children('*[type=submit]').bind('click', function(){
				return validate(o, options);
			});
		});
	};
})(jQuery);
function validate(obj, options) {
    var objs = obj.children('*[class*=required], *[class*=validate]');
    var isValid = 0;
    $(objs).each(function() {
		var o = $(this);
        if(!o.attr('baseClass')) o.attr('baseClass', o.attr('class'));
        var value = o.val();
        if(o.hasClass('email')){
			var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9])+$/;
			if (filter.test(value)) {
				o.removeClass(options.cssClass);
				isValid++;
			}
			else {
				if (o.hasClass('required')) o.addClass(options.cssClass);
				else {
					if (o.hasClass('validate') && value.length > 0) o.addClass(options.cssClass);
					else {
						o.removeClass(options.cssClass);
						isValid++;
					}
				}
			}
		}
		else if(o.hasClass('chars')){
			var filter = /^([a-zA-Z]){3,18}$/;
			if (filter.test(value)) {
				o.removeClass(options.cssClass);
				isValid++;
			} else {
				if (o.hasClass('required')) o.addClass(options.cssClass);
				else {
					if (o.hasClass('validate')) {
						o.removeClass(options.cssClass);
						isValid++;
					}
				}
			}
		}
        else if(o.hasClass('textarea')){
			if (value.length > 0 && value != o.attr('def')) {
				o.removeClass(options.cssClass);
				isValid++;
			}
			else {
				if (o.hasClass('required')) o.addClass(options.cssClass);
				else {
					if (o.hasClass('validate')) {
						o.removeClass(options.cssClass);
						isValid++;
					}
				}
			}
		}
        else if(o.hasClass('checkbox')){
			if (o.attr('checked')) {
				$('label[for=' + o.attr('id') + ']').removeClass(options.cssClass);
				isValid++;
			}
			else {
				if (o.hasClass('required')) $('label[for=' + o.attr('id') + ']').addClass(options.cssClass);
				else {
					if (o.hasClass('validate')) {
						o.removeClass(options.cssClass);
						isValid++;
					}
				}
			}
		}
		else if(o.hasClass('phone')){
			var filter = /^([0-9\.\-\/]){8,11}$/;
			if (filter.test(value)) {
				o.removeClass(options.cssClass);
				isValid++;
			}
			else {
				if (o.hasClass('required')) o.addClass(options.cssClass);
				else {
					if (o.hasClass('validate') != -1 && value.length > 0) o.addClass(options.cssClass);
					else {
						o.removeClass(options.cssClass);
						isValid++;
					}
				}
			}
		}
		else{
			if (value.length > 0) {
				o.removeClass(options.cssClass);
				isValid++;
			}
			else {
				if (o.hasClass('required')) o.addClass(options.cssClass);
				else {
					if (o.hasClass('validate')) {
						o.removeClass(options.cssClass);
						isValid++;
					}
				}
			}
        }
    });
    if (isValid < $(objs).length - 1) isValid = false;
    return isValid;
}