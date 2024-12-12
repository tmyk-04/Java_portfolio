/**
 * 
 */
'use strict';

function sanitize(input) {
	// gフラグですべての文字列を対象にする
			return input.replace(/[&<>"']/g, function(match) {
				switch (match) {
					case '&': return '&amp;';
					case '<': return '&lt;';
					case '>': return '&gt;';
					case '"': return '&quot;';
					case "'": return '&#x27;';
					default: return match;
				}
			});
		}