% Dylan Balata
% CS151-005
% cs151sp15assn3
% correlation of length vs force applied using engineering and true methods
% of measurement with outside set of data forcelength.txt

clear
clc
close ALL
format long

load forcelength.txt; % Data File name
force = forcelength(:,1);
length = forcelength(:,2);
lengthm = length./1000; % length to meters
forcelengthm = [force lengthm]; % forcelength to meters
estress = force./(2*pi*6.4); % engineering stress
estrain = (lengthm - .025)./.025; % engineering strain
tstress = (force.*lengthm)./((2*pi*6.4)*.025); % true stress
tstrain = log(lengthm./.025); % true strain

figure(1) % Plot of Force and Stress
plot(force,estress,'b')
hold on
plot (force,tstress,'r')
title('Force v Stress')
legend('Engineering','True')
xlabel('Force')
ylabel('Stress')

figure(2) % Plot of Length and Strain
plot (lengthm,estrain,'b')
hold on 
plot (lengthm,tstrain,'r')
title('Length v Strain')
legend('Engineering','True')
xlabel('Length')
ylabel('Strain')

figure(3) % Plot of Strain and Stress
plot(estrain,estress, 'b')
hold on
plot(tstrain,tstress, 'r')
title('Strain v Stress')
legend('Engineering','True')
xlabel('Strain')
ylabel('Stress')

[forcelengthrow,forcelengthcol]=size(forcelength); % Used to determine middle 3 average
averageforce= mean(forcelength((((forcelengthrow-1)/2)-1):(((forcelengthrow-1)/2)+1),:)); 

estressavg = mean(estress); % Averages
estrainavg = mean(estrain);
tstressavg = mean(tstress);
tstrainavg = mean(tstrain);

mid3estressavg = mean(estress((((forcelengthrow-1)/2)-1):(((forcelengthrow-1)/2)+1),:)); % Takes average of middle 3 values
mid3estrainavg = mean(estrain((((forcelengthrow-1)/2)-1):(((forcelengthrow-1)/2)+1),:));
mid3tstressavg = mean(tstress((((forcelengthrow-1)/2)-1):(((forcelengthrow-1)/2)+1),:));
mid3tstrainavg = mean(tstrain((((forcelengthrow-1)/2)-1):(((forcelengthrow-1)/2)+1),:));

Stress_Strain = [estressavg estrainavg %Table
    mid3estressavg mid3estrainavg
    tstressavg tstrainavg
    mid3tstressavg mid3tstrainavg]

