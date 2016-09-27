% Dylan Balata
% cs151sp15assn8
% Creating a matrix with a loop

clear
clc
close ALL

load population15

n = length(X'); % # of X values

avgx = mean(X); % Average value of X
sumx = sum(X); % Sum of X
logy = log10(Y); % Log base 10 of Y
sumlogy = sum(logy); % Sum of "
sumx2 = sumx.^2; % The sum of X, squared
avgx2 = mean(X.^2); % The Average of X, squared

b = 10.^((sumx*logy-avgx*sumlogy)/(sumx2-n*avgx2)); % Value of b
a = 10.^(sum(logy))/n-avgx*log10(b); % Value of a

for i = 1:n; % Loop to convert n many values
    newy = a.*b.^X;
end

plot(X,newy);