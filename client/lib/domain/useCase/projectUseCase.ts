import { ProjectGateway } from '../model/gateways/projectGatewat';
import { User } from '../model/user';

export class GetProjectsUseCase {
  private projectGateway: ProjectGateway;

  constructor(projectGateway: ProjectGateway) {
    this.projectGateway = projectGateway;
  }
  public async getProjectByUser(user: User) {
    try {
      const data = await this.projectGateway.getProjectsByUser(user);
      return data;
    } catch (errorUseCase) {
      console.log(errorUseCase);
      throw errorUseCase;
    }
  }
}
