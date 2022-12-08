function accuracy = jordanKuschnerCS170()
data = load("/MATLAB Drive/Projects/Feature Selection/CS170_Small_Data__96.txt");
numCorrect = 0;

for i = 1 : size(data, 1)
    testObj = data(i, 2:end);
    testLabel = data(i, 1);

    nearestNeighborDist = inf;
    nearestNeighborLoc = inf;

    for k = 1 : size(data, 1)
        disp(['Is ', int2str(i), ' a nearest neighbor with ', int2str(k), '?']);
        if k ~= i
            distance = sqrt(sum((testObj - data(k, 2:end)).^2));
            if distance < nearestNeighborDist
                nearestNeighborDist = distance;
                nearestNeighborLoc = k;
                nearestNeighborLabel = data(nearestNeighborLoc, 1);
            end
        end
    end

    if testLabel == nearestNeighborLabel
        numCorrect = numCorrect + 1;

    end
    accuracy = numCorrect / size(data, 1);

end

