% Dylan Balata
% CS 151-005
% Assignment 6 Second
% Determines parabola portion

function parabola =  cs151sp15assn6second(coeff,startxdomain,endxdomain)
x = [startxdomain:.1:endxdomain]; % x values of parabola
y = coeff(1).*x.^2+coeff(2).*x+coeff(3); % y values of parabola
plot(x,y,'b') % plots parabola
