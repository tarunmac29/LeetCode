class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        row = 0
        col = 0
        m = len(matrix[0])
        n = len(matrix)
        low = 0
        high = (m * n) - 1
        while low <= high:
            mid = low + (high - low) // 2
            midvalue = matrix[mid // m][mid % m]
            if midvalue == target:
                return True
            elif midvalue > target:
                high = mid - 1
            else:
                low = mid + 1
        return False
