% Dylan Balata
% CS 151-005
% Assignment 6 Second

function parabola =  cs151sp15assn5second(a,b,c,startxdomain,endxdomain)
x = [startxdomain:.1:endxdomain];
y = a.*x.^2+b.*x+c;
plot(x,y,'b')
hold on
plot(x(end),y(end),'o')
