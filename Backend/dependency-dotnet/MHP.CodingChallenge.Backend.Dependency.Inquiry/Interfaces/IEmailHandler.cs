namespace MHP.CodingChallenge.Backend.Dependency.Inquiry.Interfaces
{
    public interface IEmailHandler
    {
        void SendEmail(Dependency.Inquiry.Inquiry inquiry);
    }
}