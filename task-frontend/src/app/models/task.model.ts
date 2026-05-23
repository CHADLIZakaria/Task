export type Task = {
    id: number;
    description: string;
}
export type TaskRequest = {
    description: string;
}
export type ResponseApi<T> = {
    status: number;
    message: string;
    error: string[];
    data: T
}